/*
 * Copyright (c) 2016 Nova Ordis LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.novaordis.playground.java.xml.stax;

import javax.xml.stream.Location;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileReader;

/**
 * @author Ovidiu Feodorov <ovidiu@novaordis.com>
 * @since 11/9/16
 */
public class Main {

    // Constants -------------------------------------------------------------------------------------------------------

    // Static ----------------------------------------------------------------------------------------------------------

    public static void main(String[] args) throws Exception {

        if (args.length == 0) {
            throw new Exception("XML file name should be specified as the first command line argument");
        }

        File xmlFile = new File(args[0]);

        //
        // instantiate the factory
        //

        XMLInputFactory factory = XMLInputFactory.newInstance();

        //
        // configure the factory
        //

        //
        // get the parser
        //

        XMLEventReader reader = factory.createXMLEventReader(new FileReader(xmlFile));

        //
        // iterate, and also manage location
        //

        while(reader.hasNext()) {

            XMLEvent e = reader.nextEvent();

            Location location = e.getLocation();

            System.out.println(
                    "[" + location.getLineNumber() + ":" + location.getColumnNumber() + "]: " +
                            e.toString());
        }
    }

    // Attributes ------------------------------------------------------------------------------------------------------

    // Constructors ----------------------------------------------------------------------------------------------------

    // Public ----------------------------------------------------------------------------------------------------------

    // Package protected -----------------------------------------------------------------------------------------------

    // Protected -------------------------------------------------------------------------------------------------------

    // Private ---------------------------------------------------------------------------------------------------------

    // Inner classes ---------------------------------------------------------------------------------------------------

}
