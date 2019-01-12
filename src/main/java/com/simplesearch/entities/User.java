package com.simplesearch.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Representation of user record in users.json
 */
public class User extends StandardEntity {
    @JsonProperty("_id")
    private long id;
    private String name;
    private String alias;
    @JsonProperty("created_at")
    private String createdAt;
    private boolean active;
    private boolean verified;
    private boolean shared;
    private String locale;
    private String timezone;
    @JsonProperty("last_login_at")
    private String lastLoginAt;
    private String email;
    private String phone;
    private String signature;
    @JsonProperty("organization_id")
    private Long organizationId;
    private List<String> tags;
    private boolean suspended;
    private String role;

    public User() {
	super();
    }

    public User(long id, String url, String externalId, String name, String alias, String createdAt, boolean active,
	    boolean verified, boolean shared, String locale, String timezone, String lastLoginAt, String email,
	    String phone, String signature, Long organizationId, List<String> tags, boolean suspended, String role) {
	super(url, externalId);
	this.id = id;
	this.name = name;
	this.alias = alias;
	this.createdAt = createdAt;
	this.active = active;
	this.verified = verified;
	this.shared = shared;
	this.locale = locale;
	this.timezone = timezone;
	this.lastLoginAt = lastLoginAt;
	this.email = email;
	this.phone = phone;
	this.signature = signature;
	this.organizationId = organizationId;
	this.tags = tags;
	this.suspended = suspended;
	this.role = role;
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

    public String getAlias() {
	return alias;
    }

    public void setAlias(String alias) {
	this.alias = alias;
    }

    public String getCreatedAt() {
	return createdAt;
    }

    public void setCreatedAt(String createdAt) {
	this.createdAt = createdAt;
    }

    public boolean isActive() {
	return active;
    }

    public void setActive(boolean active) {
	this.active = active;
    }

    public boolean isVerified() {
	return verified;
    }

    public void setVerified(boolean verified) {
	this.verified = verified;
    }

    public boolean isShared() {
	return shared;
    }

    public void setShared(boolean shared) {
	this.shared = shared;
    }

    public String getLocale() {
	return locale;
    }

    public void setLocale(String locale) {
	this.locale = locale;
    }

    public String getTimezone() {
	return timezone;
    }

    public void setTimezone(String timezone) {
	this.timezone = timezone;
    }

    public String getLastLoginAt() {
	return lastLoginAt;
    }

    public void setLastLoginAt(String lastLoginAt) {
	this.lastLoginAt = lastLoginAt;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public String getSignature() {
	return signature;
    }

    public void setSignature(String signature) {
	this.signature = signature;
    }

    public Long getOrganizationId() {
	return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
	this.organizationId = organizationId;
    }

    public List<String> getTags() {
	return tags;
    }

    public void setTags(List<String> tags) {
	this.tags = tags;
    }

    public boolean isSuspended() {
	return suspended;
    }

    public void setSuspended(boolean suspended) {
	this.suspended = suspended;
    }

    public String getRole() {
	return role;
    }

    public void setRole(String role) {
	this.role = role;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + (active ? 1231 : 1237);
	result = prime * result + ((alias == null) ? 0 : alias.hashCode());
	result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + (int) (id ^ (id >>> 32));
	result = prime * result + ((lastLoginAt == null) ? 0 : lastLoginAt.hashCode());
	result = prime * result + ((locale == null) ? 0 : locale.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((organizationId == null) ? 0 : organizationId.hashCode());
	result = prime * result + ((phone == null) ? 0 : phone.hashCode());
	result = prime * result + ((role == null) ? 0 : role.hashCode());
	result = prime * result + (shared ? 1231 : 1237);
	result = prime * result + ((signature == null) ? 0 : signature.hashCode());
	result = prime * result + (suspended ? 1231 : 1237);
	result = prime * result + ((tags == null) ? 0 : tags.hashCode());
	result = prime * result + ((timezone == null) ? 0 : timezone.hashCode());
	result = prime * result + (verified ? 1231 : 1237);
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
	if (!(obj instanceof User)) {
	    return false;
	}
	User other = (User) obj;
	if (active != other.active) {
	    return false;
	}
	if (alias == null) {
	    if (other.alias != null) {
		return false;
	    }
	} else if (!alias.equals(other.alias)) {
	    return false;
	}
	if (createdAt == null) {
	    if (other.createdAt != null) {
		return false;
	    }
	} else if (!createdAt.equals(other.createdAt)) {
	    return false;
	}
	if (email == null) {
	    if (other.email != null) {
		return false;
	    }
	} else if (!email.equals(other.email)) {
	    return false;
	}
	if (id != other.id) {
	    return false;
	}
	if (lastLoginAt == null) {
	    if (other.lastLoginAt != null) {
		return false;
	    }
	} else if (!lastLoginAt.equals(other.lastLoginAt)) {
	    return false;
	}
	if (locale == null) {
	    if (other.locale != null) {
		return false;
	    }
	} else if (!locale.equals(other.locale)) {
	    return false;
	}
	if (name == null) {
	    if (other.name != null) {
		return false;
	    }
	} else if (!name.equals(other.name)) {
	    return false;
	}
	if (organizationId == null) {
	    if (other.organizationId != null) {
		return false;
	    }
	} else if (!organizationId.equals(other.organizationId)) {
	    return false;
	}
	if (phone == null) {
	    if (other.phone != null) {
		return false;
	    }
	} else if (!phone.equals(other.phone)) {
	    return false;
	}
	if (role == null) {
	    if (other.role != null) {
		return false;
	    }
	} else if (!role.equals(other.role)) {
	    return false;
	}
	if (shared != other.shared) {
	    return false;
	}
	if (signature == null) {
	    if (other.signature != null) {
		return false;
	    }
	} else if (!signature.equals(other.signature)) {
	    return false;
	}
	if (suspended != other.suspended) {
	    return false;
	}
	if (tags == null) {
	    if (other.tags != null) {
		return false;
	    }
	} else if (!tags.equals(other.tags)) {
	    return false;
	}
	if (timezone == null) {
	    if (other.timezone != null) {
		return false;
	    }
	} else if (!timezone.equals(other.timezone)) {
	    return false;
	}
	if (verified != other.verified) {
	    return false;
	}
	return true;
    }

}
