package application;

import domain.entity.User;
import domain.service.UserService;

public class DeleteUserUseCase {

    private final UserService userService;

    public DeleteUserUseCase(UserService userService){
        this.userService = userService;
    }

    public void execute (User user){
        userService.createUser(user);
    }

}
