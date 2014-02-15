package com.cathlamet.ron.android.tpeptwo;


import java.util.Date;
import java.util.UUID;

public class LogItem {
private UUID mId;
private String mTitle;
private String mDescription;
private String mCriteria;
private int mHours;
private Date mDate;
private String mDocTitle;
private String mDocLink;

public LogItem(){
	//generate unique identifier
	mId = UUID.randomUUID();
	mDate = new Date();
}

@Override
public String toString(){
	return mTitle;
}

/**
 * @return the title
 */
public String getTitle() {
	return mTitle;
}

/**
 * @param title the title to set
 */
public void setTitle(String title) {
	mTitle = title;
}

/**
 * @return the description
 */
public String getDescription() {
	return mDescription;
}

/**
 * @param description the description to set
 */
public void setDescription(String description) {
	mDescription = description;
}

/**
 * @return the criteria
 */
public String getCriteria() {
	return mCriteria;
}

/**
 * @param criteria the criteria to set
 */
public void setCriteria(String criteria) {
	mCriteria = criteria;
}

/**
 * @return the hours
 */
public int getHours() {
	return mHours;
}

/**
 * @param hours the hours to set
 */
public void setHours(int hours) {
	mHours = hours;
}

/**
 * @return the date
 */
public Date getDate() {
	return mDate;
}

/**
 * @param date the date to set
 */
public void setDate(Date date) {
	mDate = date;
}

/**
 * @return the supportOne
 */
public String getDocTitle() {
	return mDocTitle;
}

/**
 * @param supportOne the supportOne to set
 */
public void setDocTitle(String supportOne) {
	mDocTitle = supportOne;
}

/**
 * @return the supportTwo
 */
public String getDocLink() {
	return mDocLink;
}

/**
 * @param supportTwo the supportTwo to set
 */
public void setDocLink(String supportTwo) {
	mDocLink = supportTwo;
}

/**
 * @return the id
 */
public UUID getId() {
	return mId;
}

}
