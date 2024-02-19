package Personal.AIEats.Service;

import Personal.AIEats.Entity.user;
import Personal.AIEats.Repository.JpaDataUserRepository;
import Personal.AIEats.dto.MemberDTO;

import java.util.Optional;

public class UserService {

    private JpaDataUserRepository jpaDataUserRepository;

    public UserService(JpaDataUserRepository jpaDataUserRepository)
    {
        this.jpaDataUserRepository = jpaDataUserRepository;
    }

    public void save(MemberDTO memberDTO)
    {
        //1. dto -> entity 변환
        //2. repository의 save 메소드 호출
        user userEntity = user.touserEntity(memberDTO);
        jpaDataUserRepository.save(userEntity);
    }

    public MemberDTO login(MemberDTO memberDTO)
    {
        /*
        1.회원이 입력한 ID로 DB에서 조회
        2.DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호와 일치하는지 확인
        **/
        Optional<user> byMemberID = jpaDataUserRepository.findById(memberDTO.getMemberID());
        if(byMemberID.isPresent())
        {
            //조회 결과가 존재한다
            user userEntity = byMemberID.get();
            if(userEntity.getPwd().equals(memberDTO.getMemberPwd()))
            {
                //비밀번호 일치
                //entity -> dto 변환 후 리턴
                MemberDTO dto = MemberDTO.touserDTO(userEntity);
                return dto;
            }
            else {
                //비밀번호 불일치
                return null;
            }
        }else{
            //조회 결과가 존재하지 않는다
            return null;
        }
    }


}
