package com.persagy.meeting.entity;

import java.util.ArrayList;
import java.util.List;

public class BookingMeetingRoomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookingMeetingRoomExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andBookingRoomIdIsNull() {
            addCriterion("booking_room_id is null");
            return (Criteria) this;
        }

        public Criteria andBookingRoomIdIsNotNull() {
            addCriterion("booking_room_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookingRoomIdEqualTo(String value) {
            addCriterion("booking_room_id =", value, "bookingRoomId");
            return (Criteria) this;
        }

        public Criteria andBookingRoomIdNotEqualTo(String value) {
            addCriterion("booking_room_id <>", value, "bookingRoomId");
            return (Criteria) this;
        }

        public Criteria andBookingRoomIdGreaterThan(String value) {
            addCriterion("booking_room_id >", value, "bookingRoomId");
            return (Criteria) this;
        }

        public Criteria andBookingRoomIdGreaterThanOrEqualTo(String value) {
            addCriterion("booking_room_id >=", value, "bookingRoomId");
            return (Criteria) this;
        }

        public Criteria andBookingRoomIdLessThan(String value) {
            addCriterion("booking_room_id <", value, "bookingRoomId");
            return (Criteria) this;
        }

        public Criteria andBookingRoomIdLessThanOrEqualTo(String value) {
            addCriterion("booking_room_id <=", value, "bookingRoomId");
            return (Criteria) this;
        }

        public Criteria andBookingRoomIdLike(String value) {
            addCriterion("booking_room_id like", value, "bookingRoomId");
            return (Criteria) this;
        }

        public Criteria andBookingRoomIdNotLike(String value) {
            addCriterion("booking_room_id not like", value, "bookingRoomId");
            return (Criteria) this;
        }

        public Criteria andBookingRoomIdIn(List<String> values) {
            addCriterion("booking_room_id in", values, "bookingRoomId");
            return (Criteria) this;
        }

        public Criteria andBookingRoomIdNotIn(List<String> values) {
            addCriterion("booking_room_id not in", values, "bookingRoomId");
            return (Criteria) this;
        }

        public Criteria andBookingRoomIdBetween(String value1, String value2) {
            addCriterion("booking_room_id between", value1, value2, "bookingRoomId");
            return (Criteria) this;
        }

        public Criteria andBookingRoomIdNotBetween(String value1, String value2) {
            addCriterion("booking_room_id not between", value1, value2, "bookingRoomId");
            return (Criteria) this;
        }

        public Criteria andBookingPersonIdIsNull() {
            addCriterion("booking_person_id is null");
            return (Criteria) this;
        }

        public Criteria andBookingPersonIdIsNotNull() {
            addCriterion("booking_person_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookingPersonIdEqualTo(String value) {
            addCriterion("booking_person_id =", value, "bookingPersonId");
            return (Criteria) this;
        }

        public Criteria andBookingPersonIdNotEqualTo(String value) {
            addCriterion("booking_person_id <>", value, "bookingPersonId");
            return (Criteria) this;
        }

        public Criteria andBookingPersonIdGreaterThan(String value) {
            addCriterion("booking_person_id >", value, "bookingPersonId");
            return (Criteria) this;
        }

        public Criteria andBookingPersonIdGreaterThanOrEqualTo(String value) {
            addCriterion("booking_person_id >=", value, "bookingPersonId");
            return (Criteria) this;
        }

        public Criteria andBookingPersonIdLessThan(String value) {
            addCriterion("booking_person_id <", value, "bookingPersonId");
            return (Criteria) this;
        }

        public Criteria andBookingPersonIdLessThanOrEqualTo(String value) {
            addCriterion("booking_person_id <=", value, "bookingPersonId");
            return (Criteria) this;
        }

        public Criteria andBookingPersonIdLike(String value) {
            addCriterion("booking_person_id like", value, "bookingPersonId");
            return (Criteria) this;
        }

        public Criteria andBookingPersonIdNotLike(String value) {
            addCriterion("booking_person_id not like", value, "bookingPersonId");
            return (Criteria) this;
        }

        public Criteria andBookingPersonIdIn(List<String> values) {
            addCriterion("booking_person_id in", values, "bookingPersonId");
            return (Criteria) this;
        }

        public Criteria andBookingPersonIdNotIn(List<String> values) {
            addCriterion("booking_person_id not in", values, "bookingPersonId");
            return (Criteria) this;
        }

        public Criteria andBookingPersonIdBetween(String value1, String value2) {
            addCriterion("booking_person_id between", value1, value2, "bookingPersonId");
            return (Criteria) this;
        }

        public Criteria andBookingPersonIdNotBetween(String value1, String value2) {
            addCriterion("booking_person_id not between", value1, value2, "bookingPersonId");
            return (Criteria) this;
        }

        public Criteria andBookingPersonNameIsNull() {
            addCriterion("booking_person_name is null");
            return (Criteria) this;
        }

        public Criteria andBookingPersonNameIsNotNull() {
            addCriterion("booking_person_name is not null");
            return (Criteria) this;
        }

        public Criteria andBookingPersonNameEqualTo(String value) {
            addCriterion("booking_person_name =", value, "bookingPersonName");
            return (Criteria) this;
        }

        public Criteria andBookingPersonNameNotEqualTo(String value) {
            addCriterion("booking_person_name <>", value, "bookingPersonName");
            return (Criteria) this;
        }

        public Criteria andBookingPersonNameGreaterThan(String value) {
            addCriterion("booking_person_name >", value, "bookingPersonName");
            return (Criteria) this;
        }

        public Criteria andBookingPersonNameGreaterThanOrEqualTo(String value) {
            addCriterion("booking_person_name >=", value, "bookingPersonName");
            return (Criteria) this;
        }

        public Criteria andBookingPersonNameLessThan(String value) {
            addCriterion("booking_person_name <", value, "bookingPersonName");
            return (Criteria) this;
        }

        public Criteria andBookingPersonNameLessThanOrEqualTo(String value) {
            addCriterion("booking_person_name <=", value, "bookingPersonName");
            return (Criteria) this;
        }

        public Criteria andBookingPersonNameLike(String value) {
            addCriterion("booking_person_name like", value, "bookingPersonName");
            return (Criteria) this;
        }

        public Criteria andBookingPersonNameNotLike(String value) {
            addCriterion("booking_person_name not like", value, "bookingPersonName");
            return (Criteria) this;
        }

        public Criteria andBookingPersonNameIn(List<String> values) {
            addCriterion("booking_person_name in", values, "bookingPersonName");
            return (Criteria) this;
        }

        public Criteria andBookingPersonNameNotIn(List<String> values) {
            addCriterion("booking_person_name not in", values, "bookingPersonName");
            return (Criteria) this;
        }

        public Criteria andBookingPersonNameBetween(String value1, String value2) {
            addCriterion("booking_person_name between", value1, value2, "bookingPersonName");
            return (Criteria) this;
        }

        public Criteria andBookingPersonNameNotBetween(String value1, String value2) {
            addCriterion("booking_person_name not between", value1, value2, "bookingPersonName");
            return (Criteria) this;
        }

        public Criteria andBookingPersonPictureIsNull() {
            addCriterion("booking_person_picture is null");
            return (Criteria) this;
        }

        public Criteria andBookingPersonPictureIsNotNull() {
            addCriterion("booking_person_picture is not null");
            return (Criteria) this;
        }

        public Criteria andBookingPersonPictureEqualTo(String value) {
            addCriterion("booking_person_picture =", value, "bookingPersonPicture");
            return (Criteria) this;
        }

        public Criteria andBookingPersonPictureNotEqualTo(String value) {
            addCriterion("booking_person_picture <>", value, "bookingPersonPicture");
            return (Criteria) this;
        }

        public Criteria andBookingPersonPictureGreaterThan(String value) {
            addCriterion("booking_person_picture >", value, "bookingPersonPicture");
            return (Criteria) this;
        }

        public Criteria andBookingPersonPictureGreaterThanOrEqualTo(String value) {
            addCriterion("booking_person_picture >=", value, "bookingPersonPicture");
            return (Criteria) this;
        }

        public Criteria andBookingPersonPictureLessThan(String value) {
            addCriterion("booking_person_picture <", value, "bookingPersonPicture");
            return (Criteria) this;
        }

        public Criteria andBookingPersonPictureLessThanOrEqualTo(String value) {
            addCriterion("booking_person_picture <=", value, "bookingPersonPicture");
            return (Criteria) this;
        }

        public Criteria andBookingPersonPictureLike(String value) {
            addCriterion("booking_person_picture like", value, "bookingPersonPicture");
            return (Criteria) this;
        }

        public Criteria andBookingPersonPictureNotLike(String value) {
            addCriterion("booking_person_picture not like", value, "bookingPersonPicture");
            return (Criteria) this;
        }

        public Criteria andBookingPersonPictureIn(List<String> values) {
            addCriterion("booking_person_picture in", values, "bookingPersonPicture");
            return (Criteria) this;
        }

        public Criteria andBookingPersonPictureNotIn(List<String> values) {
            addCriterion("booking_person_picture not in", values, "bookingPersonPicture");
            return (Criteria) this;
        }

        public Criteria andBookingPersonPictureBetween(String value1, String value2) {
            addCriterion("booking_person_picture between", value1, value2, "bookingPersonPicture");
            return (Criteria) this;
        }

        public Criteria andBookingPersonPictureNotBetween(String value1, String value2) {
            addCriterion("booking_person_picture not between", value1, value2, "bookingPersonPicture");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andMeetingEndTimeIsNull() {
            addCriterion("meeting_end_time is null");
            return (Criteria) this;
        }

        public Criteria andMeetingEndTimeIsNotNull() {
            addCriterion("meeting_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingEndTimeEqualTo(String value) {
            addCriterion("meeting_end_time =", value, "meetingEndTime");
            return (Criteria) this;
        }

        public Criteria andMeetingEndTimeNotEqualTo(String value) {
            addCriterion("meeting_end_time <>", value, "meetingEndTime");
            return (Criteria) this;
        }

        public Criteria andMeetingEndTimeGreaterThan(String value) {
            addCriterion("meeting_end_time >", value, "meetingEndTime");
            return (Criteria) this;
        }

        public Criteria andMeetingEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("meeting_end_time >=", value, "meetingEndTime");
            return (Criteria) this;
        }

        public Criteria andMeetingEndTimeLessThan(String value) {
            addCriterion("meeting_end_time <", value, "meetingEndTime");
            return (Criteria) this;
        }

        public Criteria andMeetingEndTimeLessThanOrEqualTo(String value) {
            addCriterion("meeting_end_time <=", value, "meetingEndTime");
            return (Criteria) this;
        }

        public Criteria andMeetingEndTimeLike(String value) {
            addCriterion("meeting_end_time like", value, "meetingEndTime");
            return (Criteria) this;
        }

        public Criteria andMeetingEndTimeNotLike(String value) {
            addCriterion("meeting_end_time not like", value, "meetingEndTime");
            return (Criteria) this;
        }

        public Criteria andMeetingEndTimeIn(List<String> values) {
            addCriterion("meeting_end_time in", values, "meetingEndTime");
            return (Criteria) this;
        }

        public Criteria andMeetingEndTimeNotIn(List<String> values) {
            addCriterion("meeting_end_time not in", values, "meetingEndTime");
            return (Criteria) this;
        }

        public Criteria andMeetingEndTimeBetween(String value1, String value2) {
            addCriterion("meeting_end_time between", value1, value2, "meetingEndTime");
            return (Criteria) this;
        }

        public Criteria andMeetingEndTimeNotBetween(String value1, String value2) {
            addCriterion("meeting_end_time not between", value1, value2, "meetingEndTime");
            return (Criteria) this;
        }

        public Criteria andMeetingRemindersIsNull() {
            addCriterion("meeting_reminders is null");
            return (Criteria) this;
        }

        public Criteria andMeetingRemindersIsNotNull() {
            addCriterion("meeting_reminders is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingRemindersEqualTo(String value) {
            addCriterion("meeting_reminders =", value, "meetingReminders");
            return (Criteria) this;
        }

        public Criteria andMeetingRemindersNotEqualTo(String value) {
            addCriterion("meeting_reminders <>", value, "meetingReminders");
            return (Criteria) this;
        }

        public Criteria andMeetingRemindersGreaterThan(String value) {
            addCriterion("meeting_reminders >", value, "meetingReminders");
            return (Criteria) this;
        }

        public Criteria andMeetingRemindersGreaterThanOrEqualTo(String value) {
            addCriterion("meeting_reminders >=", value, "meetingReminders");
            return (Criteria) this;
        }

        public Criteria andMeetingRemindersLessThan(String value) {
            addCriterion("meeting_reminders <", value, "meetingReminders");
            return (Criteria) this;
        }

        public Criteria andMeetingRemindersLessThanOrEqualTo(String value) {
            addCriterion("meeting_reminders <=", value, "meetingReminders");
            return (Criteria) this;
        }

        public Criteria andMeetingRemindersLike(String value) {
            addCriterion("meeting_reminders like", value, "meetingReminders");
            return (Criteria) this;
        }

        public Criteria andMeetingRemindersNotLike(String value) {
            addCriterion("meeting_reminders not like", value, "meetingReminders");
            return (Criteria) this;
        }

        public Criteria andMeetingRemindersIn(List<String> values) {
            addCriterion("meeting_reminders in", values, "meetingReminders");
            return (Criteria) this;
        }

        public Criteria andMeetingRemindersNotIn(List<String> values) {
            addCriterion("meeting_reminders not in", values, "meetingReminders");
            return (Criteria) this;
        }

        public Criteria andMeetingRemindersBetween(String value1, String value2) {
            addCriterion("meeting_reminders between", value1, value2, "meetingReminders");
            return (Criteria) this;
        }

        public Criteria andMeetingRemindersNotBetween(String value1, String value2) {
            addCriterion("meeting_reminders not between", value1, value2, "meetingReminders");
            return (Criteria) this;
        }

        public Criteria andMeetingStartTimeIsNull() {
            addCriterion("meeting_start_time is null");
            return (Criteria) this;
        }

        public Criteria andMeetingStartTimeIsNotNull() {
            addCriterion("meeting_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingStartTimeEqualTo(String value) {
            addCriterion("meeting_start_time =", value, "meetingStartTime");
            return (Criteria) this;
        }

        public Criteria andMeetingStartTimeNotEqualTo(String value) {
            addCriterion("meeting_start_time <>", value, "meetingStartTime");
            return (Criteria) this;
        }

        public Criteria andMeetingStartTimeGreaterThan(String value) {
            addCriterion("meeting_start_time >", value, "meetingStartTime");
            return (Criteria) this;
        }

        public Criteria andMeetingStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("meeting_start_time >=", value, "meetingStartTime");
            return (Criteria) this;
        }

        public Criteria andMeetingStartTimeLessThan(String value) {
            addCriterion("meeting_start_time <", value, "meetingStartTime");
            return (Criteria) this;
        }

        public Criteria andMeetingStartTimeLessThanOrEqualTo(String value) {
            addCriterion("meeting_start_time <=", value, "meetingStartTime");
            return (Criteria) this;
        }

        public Criteria andMeetingStartTimeLike(String value) {
            addCriterion("meeting_start_time like", value, "meetingStartTime");
            return (Criteria) this;
        }

        public Criteria andMeetingStartTimeNotLike(String value) {
            addCriterion("meeting_start_time not like", value, "meetingStartTime");
            return (Criteria) this;
        }

        public Criteria andMeetingStartTimeIn(List<String> values) {
            addCriterion("meeting_start_time in", values, "meetingStartTime");
            return (Criteria) this;
        }

        public Criteria andMeetingStartTimeNotIn(List<String> values) {
            addCriterion("meeting_start_time not in", values, "meetingStartTime");
            return (Criteria) this;
        }

        public Criteria andMeetingStartTimeBetween(String value1, String value2) {
            addCriterion("meeting_start_time between", value1, value2, "meetingStartTime");
            return (Criteria) this;
        }

        public Criteria andMeetingStartTimeNotBetween(String value1, String value2) {
            addCriterion("meeting_start_time not between", value1, value2, "meetingStartTime");
            return (Criteria) this;
        }

        public Criteria andParticipantsIsNull() {
            addCriterion("participants is null");
            return (Criteria) this;
        }

        public Criteria andParticipantsIsNotNull() {
            addCriterion("participants is not null");
            return (Criteria) this;
        }

        public Criteria andParticipantsEqualTo(String value) {
            addCriterion("participants =", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsNotEqualTo(String value) {
            addCriterion("participants <>", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsGreaterThan(String value) {
            addCriterion("participants >", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsGreaterThanOrEqualTo(String value) {
            addCriterion("participants >=", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsLessThan(String value) {
            addCriterion("participants <", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsLessThanOrEqualTo(String value) {
            addCriterion("participants <=", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsLike(String value) {
            addCriterion("participants like", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsNotLike(String value) {
            addCriterion("participants not like", value, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsIn(List<String> values) {
            addCriterion("participants in", values, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsNotIn(List<String> values) {
            addCriterion("participants not in", values, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsBetween(String value1, String value2) {
            addCriterion("participants between", value1, value2, "participants");
            return (Criteria) this;
        }

        public Criteria andParticipantsNotBetween(String value1, String value2) {
            addCriterion("participants not between", value1, value2, "participants");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNull() {
            addCriterion("room_id is null");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNotNull() {
            addCriterion("room_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomIdEqualTo(String value) {
            addCriterion("room_id =", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotEqualTo(String value) {
            addCriterion("room_id <>", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThan(String value) {
            addCriterion("room_id >", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThanOrEqualTo(String value) {
            addCriterion("room_id >=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThan(String value) {
            addCriterion("room_id <", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThanOrEqualTo(String value) {
            addCriterion("room_id <=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLike(String value) {
            addCriterion("room_id like", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotLike(String value) {
            addCriterion("room_id not like", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIn(List<String> values) {
            addCriterion("room_id in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotIn(List<String> values) {
            addCriterion("room_id not in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdBetween(String value1, String value2) {
            addCriterion("room_id between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotBetween(String value1, String value2) {
            addCriterion("room_id not between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomNameIsNull() {
            addCriterion("room_name is null");
            return (Criteria) this;
        }

        public Criteria andRoomNameIsNotNull() {
            addCriterion("room_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoomNameEqualTo(String value) {
            addCriterion("room_name =", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotEqualTo(String value) {
            addCriterion("room_name <>", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameGreaterThan(String value) {
            addCriterion("room_name >", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameGreaterThanOrEqualTo(String value) {
            addCriterion("room_name >=", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLessThan(String value) {
            addCriterion("room_name <", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLessThanOrEqualTo(String value) {
            addCriterion("room_name <=", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLike(String value) {
            addCriterion("room_name like", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotLike(String value) {
            addCriterion("room_name not like", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameIn(List<String> values) {
            addCriterion("room_name in", values, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotIn(List<String> values) {
            addCriterion("room_name not in", values, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameBetween(String value1, String value2) {
            addCriterion("room_name between", value1, value2, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotBetween(String value1, String value2) {
            addCriterion("room_name not between", value1, value2, "roomName");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTopicIsNull() {
            addCriterion("topic is null");
            return (Criteria) this;
        }

        public Criteria andTopicIsNotNull() {
            addCriterion("topic is not null");
            return (Criteria) this;
        }

        public Criteria andTopicEqualTo(String value) {
            addCriterion("topic =", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicNotEqualTo(String value) {
            addCriterion("topic <>", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicGreaterThan(String value) {
            addCriterion("topic >", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicGreaterThanOrEqualTo(String value) {
            addCriterion("topic >=", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicLessThan(String value) {
            addCriterion("topic <", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicLessThanOrEqualTo(String value) {
            addCriterion("topic <=", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicLike(String value) {
            addCriterion("topic like", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicNotLike(String value) {
            addCriterion("topic not like", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicIn(List<String> values) {
            addCriterion("topic in", values, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicNotIn(List<String> values) {
            addCriterion("topic not in", values, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicBetween(String value1, String value2) {
            addCriterion("topic between", value1, value2, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicNotBetween(String value1, String value2) {
            addCriterion("topic not between", value1, value2, "topic");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(String value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(String value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(String value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(String value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLike(String value) {
            addCriterion("update_time like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(String value) {
            addCriterion("update_time not like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<String> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<String> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(String value1, String value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andValidIsNull() {
            addCriterion("valid is null");
            return (Criteria) this;
        }

        public Criteria andValidIsNotNull() {
            addCriterion("valid is not null");
            return (Criteria) this;
        }

        public Criteria andValidEqualTo(Boolean value) {
            addCriterion("valid =", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotEqualTo(Boolean value) {
            addCriterion("valid <>", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidGreaterThan(Boolean value) {
            addCriterion("valid >", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidGreaterThanOrEqualTo(Boolean value) {
            addCriterion("valid >=", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidLessThan(Boolean value) {
            addCriterion("valid <", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidLessThanOrEqualTo(Boolean value) {
            addCriterion("valid <=", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidIn(List<Boolean> values) {
            addCriterion("valid in", values, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotIn(List<Boolean> values) {
            addCriterion("valid not in", values, "valid");
            return (Criteria) this;
        }

        public Criteria andValidBetween(Boolean value1, Boolean value2) {
            addCriterion("valid between", value1, value2, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotBetween(Boolean value1, Boolean value2) {
            addCriterion("valid not between", value1, value2, "valid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}