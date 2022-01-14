/*
 * Certain portions of this software are Copyright (C) 2006-present
 * Vanderbilt University, Institute for Software Integrated Systems.
 *
 * Certain portions of this software are contributed as a public service by
 * The National Institute of Standards and Technology (NIST) and are not
 * subject to U.S. Copyright.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above Vanderbilt University copyright notice, NIST contribution
 * notice and this permission and disclaimer notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE. THE AUTHORS OR COPYRIGHT HOLDERS SHALL NOT HAVE
 * ANY OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS,
 * OR MODIFICATIONS.
 *
 * @author Himanshu Neema
 */

package org.cpswt.hla.base;

import org.cpswt.hla.ObjectRoot;
import org.cpswt.hla.SynchronizedFederate;
import hla.rti.EventRetractionHandle;
import hla.rti.LogicalTime;
import hla.rti.ReflectedAttributes;
import org.portico.impl.hla13.types.DoubleTime;

/**
 * This class serializes reflections of the attributes of object class
 * instances that come in from the RTI.  An object of this class contains:
 * <p>
 * - a reference to the object class instance for whom attribute reflections
 * have been received
 * - the reflected attributes and their new (reflected) values
 * - the timestamp of the reflections
 * <p>
 * This class is necessary because potentially many attribute reflections
 * can come in from the RTI before a federate thread processes them.  If the
 * reflections were simply performed when they came in, such a federate thread
 * could miss several reflections.
 * <p>
 * Instead, this class allows a federate thread to apply the reflections
 * itself.  The thread calls either {@link SynchronizedFederate#getNextObjectReflector()}
 * or {@link SynchronizedFederate#getNextObjectReflectorNoWait()} to get the
 * next ObjectReflector.  It then calls {@link ObjectReflector#reflect()}
 * on this ObjectReflector to apply the attribute reflections for the object
 * class instance it contains, and then calls {@link ObjectReflector#getObjectRoot()}
 * to retrieve this instance.
 *
 * @author Harmon Nine
 */
public class ObjectReflector {
    private int objectHandle;
    private ReflectedAttributes reflectedAttributes;
    private double time;

    /**
     * DO NOT USE -- Should only be used directly by the SyncronizedFederate class.
     * The {@link SynchronizedFederate#reflectAttributeValues(int, ReflectedAttributes, byte[])}
     * method uses this constructor to create a new "receive-order" ObjectReflector.
     */
    public ObjectReflector(int objectHandle, ReflectedAttributes reflectedAttributes) {
        this.objectHandle = objectHandle;
        this.reflectedAttributes = reflectedAttributes;
    }

    /**
     * DO NOT USE -- Should only be used directly by the SyncronizedFederate class.
     * The {@link SynchronizedFederate#reflectAttributeValues(int, ReflectedAttributes, byte[], LogicalTime, EventRetractionHandle)}
     * method uses this constructor to create a new "timestamp-order" ObjectReflector.
     */
    public ObjectReflector(int objectHandle, ReflectedAttributes reflectedAttributes, LogicalTime logicalTime) {
        this.objectHandle = objectHandle;
        this.reflectedAttributes = reflectedAttributes;
        DoubleTime doubleTime = new DoubleTime();
        doubleTime.setTo(logicalTime);
        this.time = doubleTime.getTime();
    }

    /**
     * A federate or federate thread calls this method to perform the attribute
     * reflections contained in this ObjectReflector object to the object class
     * instance contained by this ObjectReflector object.
     */
    public void reflect() {
        if (this.time < 0) {
            ObjectRoot.reflect(this.objectHandle, this.reflectedAttributes);
        }
        else {
            ObjectRoot.reflect(this.objectHandle, this.reflectedAttributes, this.time);
        }
    }

    /**
     * A federate or federate thread calls this method to retrieve the object
     * class instance contained by the ObjectReflector object.  Note that if
     * this is done before {@link #reflect()} is called, the instance will not have
     * the attribute reflections contained in this ObjectReflector object.
     * <p>
     * Note that the type of the reference returned by this method is always
     * "ObjectRoot", as this is the highest super-class for all object class
     * instances.  If a reference to the actual class of the instance is desired,
     * then this ObjectRoot reference will have to be cast up the inheritance
     * hierarchy.
     *
     * @return the object class instance contained by the ObjectReflector object.
     */
    public ObjectRoot getObjectRoot() {
        return ObjectRoot.get_object(this.objectHandle);
    }

    public double getTime() {
        return this.time;
    }

    public int getUniqueID() {
        return getObjectRoot().getUniqueID();
    }
}
