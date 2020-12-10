package mate.academy.boot.bootdemo.service.impl;

import mate.academy.boot.bootdemo.model.Day;
import mate.academy.boot.bootdemo.model.Group;
import mate.academy.boot.bootdemo.repository.GroupRepository;
import mate.academy.boot.bootdemo.service.GroupService;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group save(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group getById(String id) {
        return groupRepository.findById(id);
    }
}
