/*
 * The MIT License
 *
 * Copyright 2017 Matthew Rohrlach.
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
package object;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * This is an ordered hash map of SymbolKeys (name and type) to values.
 * Test for a conflict before adding a mapping, to prevent conflicts.
 * Add a record after adding a mapping, to prevent conflicts.
 * Add every new SymbolKey to the keyList for future retrieval.
 * 
 * @author Matthew Rohrlach, lanelutgen
 */

// Objects represent <Key, Value>
public class SymbolTable extends LinkedHashMap<SymbolKey, String>
{
	private String name;
        private ArrayList<String> symbolKeyRecord = new ArrayList<>();
        private ArrayList<SymbolKey> keyList = new ArrayList<>();
	
        /**
         * Regular constructor
         * @param name 
         */
	public SymbolTable(String name)
	{
            this.name = name;
	}
        
        /**
         * Add a record of a symbol key to the list
         * @param name
         * @param type 
         */
        public void addSymbolKeyRecord(String name, String type) 
        {
            if (!symbolKeyRecord.contains(name + type)) {
                symbolKeyRecord.add(name + type);
            }
        }
        
        /**
         * Add a symbol key to the key list
         * @param newKey 
         */
        public void addSymbolKey(SymbolKey newKey)
        {
            keyList.add(newKey);
        }
        
        /**
         * Remove a record of a symbol key from the list
         * @param name
         * @param type 
         */
        public void removeSymbolKeyRecord(String name, String type)
        {
            symbolKeyRecord.remove(name + type);
        }
        
        /**
         * Remove a symbol key from the key list
         * @param newKey 
         */
        public void removeSymbolKey(SymbolKey newKey)
        {
            keyList.remove(newKey);
        }
        
        /**
         * Test for a conflict with an existing symbol key
         * @param name
         * @param type
         * @return 
         */
        public boolean checkRecordsForConflict(String name, String type)
        {
            return symbolKeyRecord.contains(name + type);
        }
	
        /**
         *  Retrieve the name of this table
         * @return 
         */
	public String getName()
	{
            return name;
	}
        
        /**
         * Retrieve value of variable with given name and type
         * @param name
         * @param type
         * @return 
         */
        public String getValueByNameAndType(String name, String type)
        {
            for (SymbolKey key : keyList)
            {
                if (key.getName().equals(name) && key.getType().equals(type))
                {
                    return this.get(key);
                }
            }
            System.err.println("Symbol not found in table!");
            return null;
        }
}
