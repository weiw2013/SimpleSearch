package com.simplesearch.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Representation of organization record in organizations.json
 */
public class Organization extends StandardEntity {
    @JsonProperty("_id")
    private long id;
    private String name;
    @JsonProperty("domain_names")
    private List<String> domainNames;
    @JsonProperty("created_at")
    private String createdAt;
    private String details;
    @JsonProperty("shared_tickets")
    private boolean sharedTickets;
    private List<String> tags;
    

    public Organization() {
	super();
    }

    public Organization(long id, String url, String externalId, String name, List<String> domainNames, String createdAt,
	    String details, boolean sharedTickets, List<String> tags) {
	super(url, externalId);
	this.id = id;
	this.name = name;
	this.domainNames = domainNames;
	this.createdAt = createdAt;
	this.details = details;
	this.sharedTickets = sharedTickets;
	this.tags = tags;
    }



    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public List<String> getDomainNames() {
	return domainNames;
    }

    public void setDomainNames(List<String> domainNames) {
	this.domainNames = domainNames;
    }

    public String getCreatedAt() {
	return createdAt;
    }

    public void setCreatedAt(String createdAt) {
	this.createdAt = createdAt;
    }

    public String getDetails() {
	return details;
    }

    public void setDetails(String details) {
	this.details = details;
    }

    public boolean isSharedTickets() {
	return sharedTickets;
    }

    public void setSharedTickets(boolean sharedTickets) {
	this.sharedTickets = sharedTickets;
    }

    public List<String> getTags() {
	return tags;
    }

    public void setTags(List<String> tags) {
	this.tags = tags;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
	result = prime * result + ((details == null) ? 0 : details.hashCode());
	result = prime * result + ((domainNames == null) ? 0 : domainNames.hashCode());
	result = prime * result + (int) (id ^ (id >>> 32));
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + (sharedTickets ? 1231 : 1237);
	result = prime * result + ((tags == null) ? 0 : tags.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (!super.equals(obj)) {
	    return false;
	}
	if (!(obj instanceof Organization)) {
	    return false;
	}
	Organization other = (Organization) obj;
	if (createdAt == null) {
	    if (other.createdAt != null) {
		return false;
	    }
	} else if (!createdAt.equals(other.createdAt)) {
	    return false;
	}
	if (details == null) {
	    if (other.details != null) {
		return false;
	    }
	} else if (!details.equals(other.details)) {
	    return false;
	}
	if (domainNames == null) {
	    if (other.domainNames != null) {
		return false;
	    }
	} else if (!domainNames.equals(other.domainNames)) {
	    return false;
	}
	if (id != other.id) {
	    return false;
	}
	if (name == null) {
	    if (other.name != null) {
		return false;
	    }
	} else if (!name.equals(other.name)) {
	    return false;
	}
	if (sharedTickets != other.sharedTickets) {
	    return false;
	}
	if (tags == null) {
	    if (other.tags != null) {
		return false;
	    }
	} else if (!tags.equals(other.tags)) {
	    return false;
	}
	return true;
    }

}
