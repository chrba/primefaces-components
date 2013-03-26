package de.morten.web;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;


@RequestScoped
@Named
public class FileUploadController {
    public void upload(FileUploadEvent event) throws IOException {
		final UploadedFile file = event.getFile();
		final BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputstream()));
		

		
		FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}
}
                    