package com.team4.hometaskmanager.groups;

public class Group {
    public int id;
    public String name;
    public User[] members;

    public Group(int id, String name, User[] members){
        this.id = id;
        this.name = name;
        this.members = members;
    }

    public Group getInstance(){
        return this;
    }
    public static final User DONALD = new User(0, "Donald Duck", "12345");
    public static final User SCROOGE = new User(1, "Scrooge McDuck", "54321");
    public static final User DAISY = new User(2, "Daisy Duck", "abcde");
    public static final User HUEY = new User(3, "Huey Duck", "edcba");
    public static final User DEWEY = new User(4, "Dewey Duck", "13524");
    public static final User LOUIE = new User(5, "Louie Duck", "42531");
    public static final Group[] GROUPS = {
            new Group(0, "Groepje 1", new User[]{SCROOGE, DONALD, DAISY}),
            new Group(1, "De neefjes", new User[]{DONALD, HUEY, DEWEY, LOUIE})
    };
}
