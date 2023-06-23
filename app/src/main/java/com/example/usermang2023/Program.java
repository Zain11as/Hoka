package com.example.usermang2023;

public class Program {
    private String name;
    private String country;
    private String volunteerrype;
    public String about;
    public String link;

    public Program() {
    }

    public Program(String name, String country, String volunteerrype, String about, String link) {
        this.name=name;
        this.country=country;
        this.volunteerrype=volunteerrype;
        this.about = about;
        this.link=link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getVolunteerrype() {
        return volunteerrype;
    }

    public void setVolunteerrype(String volunteerrype) {
        this.volunteerrype = volunteerrype;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "Program{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", volunteerrype='" + volunteerrype + '\'' +
                ", about='" + about + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
