/*
 * The MIT License
 *
 * Copyright 2017 matthewrohrlach.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package task;

/**
 * Template of Task objects for use with input/output objects
 * @author matthewrohrlach
 * @param <OutputObject>
 * @param <InputObject>
 */
public abstract class TaskTemplate<OutputObject,InputObject> {
    
    /**
     * Run task on given inputs
     * @param input
     * @return 
     */
    public abstract OutputObject doTask(InputObject input);
    
    /**
     * Retrieve the private input object of this task
     * @return 
     */
    public abstract InputObject getInputObject();
    
    /**
     * Print output data to console
     */
    public abstract void printOutput();
}
