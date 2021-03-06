package org.eclipse.webdav.client;

import java.io.*;
import org.eclipse.webdav.http.client.IRequestBodyWriter;
import org.eclipse.webdav.internal.kernel.DocumentMarshaler;
import org.eclipse.webdav.internal.kernel.IDocumentMarshaler;
import org.w3c.dom.Document;

/**
 * <b>Note:</b> This class/interface is part of an interim API that is still under 
 * development and expected to change significantly before reaching stability. 
 * It is being made available at this early stage to solicit feedback from pioneering 
 * adopters on the understanding that any code that uses this API will almost 
 * certainly be broken (repeatedly) as the API evolves.
 */
public class RequestBodyWriter implements IRequestBodyWriter {

    private Document body;
    private String characterEncoding;

    public RequestBodyWriter(Document document, String characterEncoding) {
        body = document;
        this.characterEncoding = characterEncoding;
    }

    public void writeRequestBody(OutputStream os) throws IOException {
        IDocumentMarshaler marshaler = new DocumentMarshaler();
        OutputStreamWriter writer = new OutputStreamWriter(os, characterEncoding);
        marshaler.print(body, writer, "utf-8"); //$NON-NLS-1$
    }
}
