package leaf.service.group;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.stereotype.Service;

import leaf.model.dao.chat.ChatRoomRepository;
import leaf.model.dao.group.GroupMemberRepository;
import leaf.model.dto.chat.ChatRoom;
import leaf.model.dto.group.GroupMember;
import leaf.model.dto.member.Member;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GroupService {

    private final GroupMemberRepository groupRepo;
    private final ChatRoomRepository chatRepo;

	public List<ChatRoom> getRoomList(Member member) {
        List<ChatRoom> roomList = new Vector<ChatRoom>();
        ChatRoom companyChat = chatRepo.findByRoomNm(member.getCompanyName()).get(0);
        roomList.add(companyChat);
        List<GroupMember> groupList = groupRepo.findByMemberId(member.getMemberId());
        for (GroupMember groupMember : groupList) {
            ChatRoom groupChat = chatRepo.findByRoomNm(groupMember.getGroupNm()).get(0);
            roomList.add(groupChat);
        }
        System.out.println(roomList);
        return roomList;
	}
}