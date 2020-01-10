package jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ifmo_group")
@NoArgsConstructor
@RequiredArgsConstructor
public class Group extends BaseIdentify{
    @Getter
    @Setter
    @NonNull
    private String groupName;

    @Getter
    @Setter
    @NonNull
    private int duration;

    @Getter
    @Setter
    @NonNull
    private int price;

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "groups")
    private List<Student> students = new ArrayList<>();
}
