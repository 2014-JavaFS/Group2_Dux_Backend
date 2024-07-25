package com.revature.dux.User;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

// Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
// JPA
public class User {
    private int userId;
    private String username;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private OffsetDateTime registrationDate;

    /* public User() {
    }

    public User(int userId, String username, String email, String password, OffsetDateTime registrationDate) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    public int getUserId() { return this.userId; }

    public void setUserId(int userId) { this.userId = userId; }

    public String getUsername() { return this.username; }

    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return this.email; }

    public void setEmail(String email) { this.email = email; }

    private String getPassword() { return this.password; }

    public boolean validatePassword(String password) { return password.equals(this.password); }

    private void setPassword(String password) { this.password = password; }

    public OffsetDateTime getRegistrationDate() { return this.registrationDate; }

    public void setRegistrationDate(OffsetDateTime registrationDate) { this.registrationDate = registrationDate; }
*/
}
