package tvUsers;

import java.util.Objects;

/**
 * SAMPLE DATA:
 *    {
 *     "postId": 1,
 *     "id": 4,
 *     "name": "alias odio sit",
 *     "email": "Lew@alysha.tv",
 *     "body": "non et atque\noccaecati deserunt quas accusantium unde odit nobis qui voluptatem\nquia voluptas consequuntur itaque dolor\net qui rerum deleniti ut occaecati"
 *   },
 */
public class Comment {

    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;

    public Comment(int postId, int id, String name, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public int getPostId() {
        return postId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return postId == comment.postId &&
                id == comment.id &&
                Objects.equals(name, comment.name) &&
                Objects.equals(email, comment.email) &&
                Objects.equals(body, comment.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, id, name, email, body);
    }

    @Override
    public String toString() {
        return "tvUsers.Comment{" +
                "postId=" + postId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
