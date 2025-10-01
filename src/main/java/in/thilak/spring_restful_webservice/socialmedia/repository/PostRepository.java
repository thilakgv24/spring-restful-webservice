package in.thilak.spring_restful_webservice.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.thilak.spring_restful_webservice.socialmedia.dao.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
