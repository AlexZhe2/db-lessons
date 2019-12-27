package jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "message")
public class TextMessage extends BaseIdentify{

    @Getter
    @Setter
    String author; //    @Column(name = "new_name" и тд)

    @Getter
    @Setter
    String text;

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar sent;

}
