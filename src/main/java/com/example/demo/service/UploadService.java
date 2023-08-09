package com.example.demo.service;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.extractor.EmbeddedDocumentUtil;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.microsoft.OfficeParser;
import org.apache.tika.parser.microsoft.ooxml.OOXMLParser;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

@Service("uploadServiceImpl")
public class UploadService {

	public String scanFile(MultipartFile file) {
		try {
			TikaInputStream stream = TikaInputStream.get(file.getInputStream());
			Parser parser = new AutoDetectParser();
		    BodyContentHandler handler = new BodyContentHandler();
		    Metadata metadata = new Metadata();
		    ParseContext context = new ParseContext();

		  //OOXMLParser parser = new OOXMLParser();
		  parser.parse(stream, handler, metadata, context);
		  
		    
		    
		    String[] metadataNames = metadata.names();
		    for(String name : metadataNames) {
		    	System.out.println(name + ": " + metadata.get(name));
		    }
		    
		    System.out.println("content:::"+ handler.toString());
		  
		}catch (IOException | TikaException | SAXException e) {
			e.printStackTrace();
		}
		return "done";
	}

}
