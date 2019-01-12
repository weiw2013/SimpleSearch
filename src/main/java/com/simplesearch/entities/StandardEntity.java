package com.simplesearch.entities;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author WEI
 *
 */
public abstract class StandardEntity {
    private String url;
    @JsonProperty("external_id")
    private String externalId;

    public StandardEntity() {
    }

    public StandardEntity(String url, String externalId) {
	super();
	this.url = url;
	this.externalId = externalId;
    }

    public String getUrl() {
	return url;
    }

    public void setUrl(String url) {
	this.url = url;
    }

    public String getExternalId() {
	return externalId;
    }

    public void setExternalId(String externalId) {
	this.externalId = externalId;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((externalId == null) ? 0 : externalId.hashCode());
	result = prime * result + ((url == null) ? 0 : url.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (!(obj instanceof StandardEntity)) {
	    return false;
	}
	StandardEntity other = (StandardEntity) obj;
	if (externalId == null) {
	    if (other.externalId != null) {
		return false;
	    }
	} else if (!externalId.equals(other.externalId)) {
	    return false;
	}
	if (url == null) {
	    if (other.url != null) {
		return false;
	    }
	} else if (!url.equals(other.url)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();

	Field[] fields = this.getClass().getDeclaredFields();
	for (Field field : fields) {
	    field.setAccessible(true);
	    try {
		builder.append(String.format("%-20s", field.getName())).append(callGetter(field.getName())).append("\n");
	    } catch (Exception e) {
		throw new RuntimeException(e);
	    }
	}

	return builder.toString();
    }

    public String getFieldNames() {
	return Arrays.stream(this.getClass().getDeclaredFields()).map(Field::getName).collect(Collectors.joining("\n"));
    }

    public Object callGetter(String fieldName) {
	PropertyDescriptor pd;
	try {
	    pd = new PropertyDescriptor(fieldName, this.getClass());
	    return pd.getReadMethod().invoke(this);
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

}
