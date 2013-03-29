package de.morten.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.apache.http.annotation.ThreadSafe;



@SessionScoped
@ThreadSafe
@Named
public class AnalyseResults implements Serializable {
	private static final long serialVersionUID = 7474880936605699044L;
	private List<AnalyseResult> list = Collections.synchronizedList(new ArrayList<AnalyseResult>());
	
	public void add(final AnalyseResult result) {
		this.list.add(result);
	}
	
	public List<AnalyseResult> getAll() {
		return this.list;
	}
	
}
