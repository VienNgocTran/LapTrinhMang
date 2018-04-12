/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuoikylaptrinhmang;

import java.io.Serializable;

/**
 *
 * @author TNV
 */
public class Mail implements Serializable{
    private int Id;
    private String Subject;
    private String From;
    private String Date;
    private String Content;

    public Mail(String Subject, String From, String Date, String Content) {
        this.Subject = Subject;
        this.From = From;
        this.Date = Date;
        this.Content = Content;
    }

    
    public Mail(int Id, String Subject, String From, String Date, String Content) {
        this.Id = Id;
        this.Subject = Subject;
        this.From = From;
        this.Date = Date;
        this.Content = Content;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String From) {
        this.From = From;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }
    
    
}
