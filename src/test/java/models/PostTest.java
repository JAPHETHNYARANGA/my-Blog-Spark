package models;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import org.junit.After;
import org.junit.jupiter.api.Test;

//import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {
    @Test
    public void NewPostObjectsGetsCorrectlyCreated_true() throws Exception{
        Post post = new Post("Day 1: Intro");
        assertEquals(true,post instanceof Post);
    }

    @Test
    public void PostInstantiatesWithContent_true() throws Exception {
        Post post = new Post("Day 1: Intro");
        assertEquals("Day 1: Intro", post.getContent());

    }
    @After
    public void tearDown() {
        Post.clearAllPosts(); //clear out all the posts before each test.
    }

    @Test
    public void AllPostsAreCorrectlyReturned_true() {
        Post post = new Post("Day 1: Intro");
        Post otherPost = new Post ("How to pair successfully");
        assertEquals(2, Post.getAll().size());
    }

    @Test
    public void AllPostsContainsAllPosts_true() {
        Post post = new Post("Day 1: Intro");
        Post otherPost = new Post ("How to pair successfully");
        assertTrue(Post.getAll().contains(post));
        assertTrue(Post.getAll().contains(otherPost));
    }
    @Test
    public void getPublished_isFalseAfterInstantiation_false() throws Exception{
        Post myPost = new Post("Day 1:Intro");
        assertEquals(false, myPost.getPublished());
    }
    @Test
    public void getId_postsInstantiatewithAnID_1() throws Exception{
        Post.clearAllPosts();
        Post myPost = new Post("Day 1:Intro");
        assertEquals(1,myPost.getId());
    }

    @Test
    public void findReturnsCorrectPost() throws Exception {
        Post post = setupNewPost();
        assertEquals(1, Post.findById(post.getId()).getId());
    }

    @Test
    public void findReturnsCorrectPostWhenMoreThanOnePostExists() throws Exception {
        Post post = setupNewPost();
        Post otherPost = new Post("How to pair successfully");
        assertEquals(2, Post.findById(otherPost.getId()).getId());
    }

}
