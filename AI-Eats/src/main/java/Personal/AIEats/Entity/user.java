package Personal.AIEats.Entity;

import Personal.AIEats.dto.MemberDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class user {

    @Id
    private String userid;
    private String name;
    private String pwd;
    private Long cash;

    public static user touserEntity(MemberDTO memberDTO)
    {
        user userEntity = new user();
        userEntity.setUserid(memberDTO.getMemberID());
        userEntity.setPwd(memberDTO.getMemberPwd());
        userEntity.setName(memberDTO.getMemberName());
        userEntity.setCash(0L);
        return userEntity;
    }
}
