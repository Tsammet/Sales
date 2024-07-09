package application;

import domain.entity.User;
import domain.service.UserService;

public class UpdateUserUseCase {

    private final UserService userService;

    public  UpdateUserUseCase(UserService userService){
        this.userService = userService;
    }

    public void execute(User user){
        userService.updateUser(user);
    }

}
