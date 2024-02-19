package Personal.AIEats.dto;
import Personal.AIEats.Entity.user;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDTO {
    private String memberID;
    private String memberPwd;
    private String memberName;

    public static MemberDTO touserDTO(user userEntity)
    {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberID(userEntity.getUserid());
        memberDTO.setMemberPwd(userEntity.getPwd());
        memberDTO.setMemberName(userEntity.getName());
        return memberDTO;
    }
}
