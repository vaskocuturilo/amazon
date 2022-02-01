package model;

import lombok.Data;

@Data
@Source(source = "Account.json")
public class Account {

    private String username;
    private String password;
}
