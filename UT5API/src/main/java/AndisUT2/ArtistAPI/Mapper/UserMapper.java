package AndisUT2.ArtistAPI.Mapper;

import AndisUT2.ArtistAPI.DTO.UserDTO;
import AndisUT2.ArtistAPI.Model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "username", target = "username")
    UserDTO userToUserDTO(User user);

    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "username", target = "username")
    User userDTOtoUser (UserDTO userDTO);
}

