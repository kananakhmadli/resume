package com.company.mapper;

import com.company.dto.SkillDto;
import com.company.dto.UserDto;
import com.company.dto.UserSkillDto;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    List<UserDto> toUserDtoList(List<User> userList);

    @Mapping(target = "plainPassword", source = "profileDesc")
    UserDto toUserDto(User user);

    UserSkillDto toUserSkillDto(UserSkill userSkill);

    SkillDto toSkillDto(Skill skill);

    @Mapping(target = "profileDesc", source = "plainPassword")
    User toUser(UserDto userDto);

}