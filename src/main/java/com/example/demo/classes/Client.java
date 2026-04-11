package com.example.demo.classes;

import java.util.ArrayList;

public class Client extends User {

    private ArrayList<Post> posts;

    public Client(String firstName,
                  String lastName,
                  String email,
                  String password,
                  Role role,
                  ArrayList<Post> posts
    ) {
        super(firstName, lastName, email, password, role);
        this.posts = posts;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public void createPost(String post) {
        var id = +1;
        var postWithId = new Post(id, post);
        posts.add(postWithId);
    }

    public void deletePost(Integer id) {
        posts.removeIf(post -> post.getId().equals(id));
    }

    @Override
    public String toString() {
        return "Client{" +
                "posts=" + posts +
                '}';
    }
}
