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
package be.ceau.itunesapi.response.feedgenerator;

import java.io.Serializable;

/**
 * Author of an iTunes {@link Feed}.
 */
public class Author implements Serializable {

	private static final long serialVersionUID = 1501415280761L;

	private String name;
	private String uri;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("Author [name=")
				.append(name)
				.append(", uri=")
				.append(uri)
				.append("]")
				.toString();
	}

}
