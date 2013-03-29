package de.morten.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class Test implements Serializable {
	private static final long serialVersionUID = -8659869049342553416L;
	private  String output = "output";

	public void setOutput(final String output) {
		this.output = output;
	}
	
	public String getOutput() {
		return this.output;
	}
}
