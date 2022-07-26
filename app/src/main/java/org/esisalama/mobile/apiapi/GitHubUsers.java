package org.esisalama.mobile.apiapi;

public class GitHubUsers {

    private String login;
    private int id;
    private String avatar_url;
    private String name;

    public GitHubUsers() {
    }

    public GitHubUsers(String login, int id, String avatar_url, String name) {
        this.login = login;
        this.id = id;
        this.avatar_url = avatar_url;
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getName() {
        return name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public void setName(String name) {
        this.name = name;
    }
}
