package org.globaldev.dtos;

import java.util.List;

public class MetadataDTO {

    private String narrative;
    private List<CommentDTO> comments;
    private List<TagDTO> tags;
    private List<ImagesDTO> images;
    private WhereDTO where;

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }

    public List<TagDTO> getTags() {
        return tags;
    }

    public void setTags(List<TagDTO> tags) {
        this.tags = tags;
    }

    public List<ImagesDTO> getImages() {
        return images;
    }

    public void setImages(List<ImagesDTO> images) {
        this.images = images;
    }

    public WhereDTO getWhere() {
        return where;
    }

    public void setWhere(WhereDTO where) {
        this.where = where;
    }
}
