package builders;

import entities.Resource;

public class ResourceBuilder {

	private Resource res;
	
	public ResourceBuilder() {
		res = new Resource();
	}
	
	public ResourceBuilder id(int id) {
		res.setId(id);
		return this;
	}
	
	public  ResourceBuilder path(String path) {
		res.setPath(path);
		return this;
	}
	
	public ResourceBuilder title(String title) {
		res.setTitle(title);
		return this;
	}
	
	public ResourceBuilder description(String desc) {
		res.setDescription(desc);
		return this;
	}
	
	public Resource build() {
		return res;
	}
}
