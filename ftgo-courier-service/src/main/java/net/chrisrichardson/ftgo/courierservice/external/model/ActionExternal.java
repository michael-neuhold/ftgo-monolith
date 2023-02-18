package net.chrisrichardson.ftgo.courierservice.external.model;

import net.chrisrichardson.ftgo.domain.ActionType;

import java.time.LocalDateTime;

public class ActionExternal {

    public ActionExternal() {
    }

    public ActionExternal(ActionType type, LocalDateTime time, Long orderId, Long courierId) {
        this.type = type;
        this.time = time;
        this.orderId = orderId;
        this.courierId = courierId;
    }

    private ActionType type;
    private LocalDateTime time;

    private Long orderId;

    private Long courierId;

    public ActionType getType() {
        return type;
    }

    public void setType(ActionType type) {
        this.type = type;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCourierId() {
        return courierId;
    }

    public void setCourierId(Long courierId) {
        this.courierId = courierId;
    }
}
