package builders;

import entities.Rank;

public class RankBuilder {

	private Rank ra;
	
	public RankBuilder() {
		ra = new Rank();
	}
	
	public RankBuilder id(int id) {
		ra.setId(id);
		return this;
	}
	
	public RankBuilder name(String name) {
		ra.setName(name);
		return this;
	}
	
	public Rank build() {
		return ra;
	}
}
