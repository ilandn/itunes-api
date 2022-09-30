/*
	Copyright 2021 Marceau Dewilde <m@ceau.be>
	
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	
		https://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
*/
package be.ceau.itunesapi.http;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 * Default {@link Connector} implementation using {@link URLConnection}.
 */
public class URLConnector implements Connector, Serializable {

    private static final long serialVersionUID = 1476515538667L;

    /**
     * Reusable, threadsafe {@link URLConnector} instance.
     */
    public static final URLConnector INSTANCE = new URLConnector();

    /**
     * {@inheritDoc}
     *
     * @throws MalformedURLException as thrown by {@link URL#URL(String)}
     */
    public String get(String link) throws IOException {
        URL url = new URL(link);
        URLConnection urlConn = url.openConnection();
        urlConn.setConnectTimeout(45 * 1000);
        urlConn.setReadTimeout((45 * 1000));

        try (InputStream is = urlConn.getInputStream();
             InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader in = new BufferedReader(isr)) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            return sb.toString().trim();
        }
    }

}
