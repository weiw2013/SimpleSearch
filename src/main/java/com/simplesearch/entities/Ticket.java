package com.simplesearch.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Representation of ticket record in tickets.json
 */
public class Ticket extends StandardEntity {
    @JsonProperty("_id")
    private String id;
    @JsonProperty("created_at")
    private String createdAt;
    private String type;
    private String subject;
    private String description;
    private String priority;
    private String status;
    @JsonProperty("submitter_id")
    private long submitterId;
    @JsonProperty("assignee_id")
    private Long assigneeId;
    @JsonProperty("organization_id")
    private Long organizationId;
    private List<String> tags;
    @JsonProperty("has_incidents")
    private boolean hasIncidents;
    @JsonProperty("due_at")
    private String dueAt;
    private String via;

    public Ticket() {
	super();
    }

    public Ticket(String id, String url, String externalId, String createdAt, String type, String subject,
	    String description, String priority, String status, long submitterId, Long assigneeId, Long organizationId,
	    List<String> tags, boolean hasIncidents, String dueAt, String via) {
	super(url, externalId);
	this.id = id;
	this.createdAt = createdAt;
	this.type = type;
	this.subject = subject;
	this.description = description;
	this.priority = priority;
	this.status = status;
	this.submitterId = submitterId;
	this.assigneeId = assigneeId;
	this.organizationId = organizationId;
	this.tags = tags;
	this.hasIncidents = hasIncidents;
	this.dueAt = dueAt;
	this.via = via;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getCreatedAt() {
	return createdAt;
    }

    public void setCreatedAt(String createdAt) {
	this.createdAt = createdAt;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public String getSubject() {
	return subject;
    }

    public void setSubject(String subject) {
	this.subject = subject;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getPriority() {
	return priority;
    }

    public void setPriority(String priority) {
	this.priority = priority;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public long getSubmitterId() {
	return submitterId;
    }

    public void setSubmitterId(long submitterId) {
	this.submitterId = submitterId;
    }

    public Long getAssigneeId() {
	return assigneeId;
    }

    public void setAssigneeId(Long assigneeId) {
	this.assigneeId = assigneeId;
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

    public boolean isHasIncidents() {
	return hasIncidents;
    }

    public void setHasIncidents(boolean hasIncidents) {
	this.hasIncidents = hasIncidents;
    }

    public String getDueAt() {
	return dueAt;
    }

    public void setDueAt(String dueAt) {
	this.dueAt = dueAt;
    }

    public String getVia() {
	return via;
    }

    public void setVia(String via) {
	this.via = via;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((assigneeId == null) ? 0 : assigneeId.hashCode());
	result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
	result = prime * result + ((description == null) ? 0 : description.hashCode());
	result = prime * result + ((dueAt == null) ? 0 : dueAt.hashCode());
	result = prime * result + (hasIncidents ? 1231 : 1237);
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((organizationId == null) ? 0 : organizationId.hashCode());
	result = prime * result + ((priority == null) ? 0 : priority.hashCode());
	result = prime * result + ((status == null) ? 0 : status.hashCode());
	result = prime * result + ((subject == null) ? 0 : subject.hashCode());
	result = prime * result + (int) (submitterId ^ (submitterId >>> 32));
	result = prime * result + ((tags == null) ? 0 : tags.hashCode());
	result = prime * result + ((type == null) ? 0 : type.hashCode());
	result = prime * result + ((via == null) ? 0 : via.hashCode());
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
	if (!(obj instanceof Ticket)) {
	    return false;
	}
	Ticket other = (Ticket) obj;
	if (assigneeId == null) {
	    if (other.assigneeId != null) {
		return false;
	    }
	} else if (!assigneeId.equals(other.assigneeId)) {
	    return false;
	}
	if (createdAt == null) {
	    if (other.createdAt != null) {
		return false;
	    }
	} else if (!createdAt.equals(other.createdAt)) {
	    return false;
	}
	if (description == null) {
	    if (other.description != null) {
		return false;
	    }
	} else if (!description.equals(other.description)) {
	    return false;
	}
	if (dueAt == null) {
	    if (other.dueAt != null) {
		return false;
	    }
	} else if (!dueAt.equals(other.dueAt)) {
	    return false;
	}
	if (hasIncidents != other.hasIncidents) {
	    return false;
	}
	if (id == null) {
	    if (other.id != null) {
		return false;
	    }
	} else if (!id.equals(other.id)) {
	    return false;
	}
	if (organizationId == null) {
	    if (other.organizationId != null) {
		return false;
	    }
	} else if (!organizationId.equals(other.organizationId)) {
	    return false;
	}
	if (priority == null) {
	    if (other.priority != null) {
		return false;
	    }
	} else if (!priority.equals(other.priority)) {
	    return false;
	}
	if (status == null) {
	    if (other.status != null) {
		return false;
	    }
	} else if (!status.equals(other.status)) {
	    return false;
	}
	if (subject == null) {
	    if (other.subject != null) {
		return false;
	    }
	} else if (!subject.equals(other.subject)) {
	    return false;
	}
	if (submitterId != other.submitterId) {
	    return false;
	}
	if (tags == null) {
	    if (other.tags != null) {
		return false;
	    }
	} else if (!tags.equals(other.tags)) {
	    return false;
	}
	if (type == null) {
	    if (other.type != null) {
		return false;
	    }
	} else if (!type.equals(other.type)) {
	    return false;
	}
	if (via == null) {
	    if (other.via != null) {
		return false;
	    }
	} else if (!via.equals(other.via)) {
	    return false;
	}
	return true;
    }

}
