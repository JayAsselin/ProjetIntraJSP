package com.example.projetintrajsp.models;

import java.util.ArrayList;
import java.util.List;

public class LibrairieDataContext {
    private static final List<Livre> listeLivres = new ArrayList<Livre>() {
        {
            add(new Livre("9781593279509", "Marijn Haverbeke", "Eloquent JavaScript, Third " +
                    "Edition", 10.95, 10, "https://images-na.ssl-images-amazon.com/images/I/91asIC1fRwL.jpg", "JavaScript lies at the heart" +
                    " of " +
                    "almost every modern web application, from social apps like " +
                    "Twitter to browser-based game frameworks like Phaser and Babylon. "
                    + "Though simple for beginners to pick up and play with, " +
                    "JavaScript is a flexible, complex language that you can use to build full-scale applications."));

            add(new Livre("9781491943533", "Nicolás Bevacqua", "Practical Modern JavaScript", 20,
                    20, "https://images-na.ssl-images-amazon.com/images/I/813hbklwWBL.jpg", "To get the most out of modern JavaScript, you need " +
                    "learn the latest features of its parent specification, ECMAScript 6 (ES6)" +
                    ".This book provides a highly practical look at ES6, without getting " +
                    "lost in the specification or its implementation details."));

            add(new Livre("9781593277574", "Nicholas C. Zakas", "Understanding ECMAScript 6",
                    5.45, 35, "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1511375876i/36642966._UY200_.jpg", "ECMAScript 6 represents the biggest update to " +
                    "the core of JavaScript in the history of the language. In Understanding" +
                    " ECMAScript 6, expert developer Nicholas C. Zakas provides a complete " +
                    "guide to the object types, syntax, and other exciting changes that " +
                    "ECMAScript 6 brings to JavaScript."));

            add(new Livre("9781449365035", "Axel Rauschmayer", "Speaking JavaScript", 17.05, 2,
                    "https://images-na.ssl-images-amazon.com/images/I/51AOPRqoYTL._SX342_SY445_QL70_ML2_.jpg",
                    "Like it or not, JavaScript is everywhere these days from browser to " +
                            "server to mobile- and now you, too, need to learn the language " +
                            "or dive deeper than you have. This concise book guides you into and " +
                            "through JavaScript, written by a veteran programmer who once " +
                            "found himself in the same position."));

            add(new Livre("9781449331818", "Addy Osmani", "Learning JavaScript Design Patterns",
                    50, 5, "https://images-na.ssl-images-amazon.com/images/I/91WlvEND3rL.jpg", "With Learning JavaScript Design Patterns, you'll " +
                    "learn how to write beautiful, structured, and maintainable JavaScript " +
                    "by applying classical and modern design patterns to the language. If you " +
                    "want to keep your code efficient, more manageable, and up-to-date with " +
                    "the latest best practices, this book is for you."));

            add(new Livre("9798602477429", "Kyle Simpson", "You Don't Know JS Yet", 23.67, 33,
                    "https://m.media-amazon.com/images/I/410f-bUBR3L.jpg", "The worldwide best selling You Don't Know JS book series is " +
                    "back for a 2nd edition: You Don't Know JS Yet. All 6 books are brand " +
                    "new, rewritten to cover all sides of JS for 2020 and beyond."));

            add(new Livre("9781484200766", "Scott Chacon and Ben Straub", "Pro Git", 2.75, 53,
                    "https://images-na.ssl-images-amazon.com/images/I/71HO8p7RaYL.jpg", "Pro Git (Second Edition) is your fully-updated guide to Git " +
                    "and its usage in the modern world. Git has come a long way since it was" +
                    " first developed by Linus Torvalds for Linux kernel development. It has " +
                    "taken the open source world by storm since its inception in 2005, and " +
                    "this book teaches you how to use it like a pro."));

            add(new Livre("9781484242216", "Caitlin Sadowski, Thomas Zimmermann",
                    "Rethinking Productivity in Software Engineering", 75.45, 12,
                    "https://m.media-amazon.com/images/I/41+mbm8o74L._AC_SY1000_.jpg", "Get the most out of this foundational reference and " +
                    "improve the productivity of your software teams. This open access book " +
                    "collects the wisdom of the 2017 Dagstuhl seminar on productivity in software" +
                    " engineering, a meeting of community leaders, who came together with " +
                    "the goal of rethinking traditional definitions and measures of productivity."));
        }
    };

    private static final List<Facture> listeFactures = new ArrayList<>();

    private static final List<DetailFacture> listeDetailFactures = new ArrayList<>();

    public void ajouterLivre(Livre livre) {
        listeLivres.add(livre);
    }

    public List<Livre> getAllLivres() {
        return listeLivres;
    }

    public void ajouterFacture(Facture facture) {
        int numFacture = getNextNumFacture();
        facture.setNumFacture(numFacture);
        listeFactures.add(facture);
    }

    public void ajouterDetailFacture(DetailFacture detailFacture) {
        listeDetailFactures.add(detailFacture);
    }

    public Livre findLivre(String isbn) {
        return this.getAllLivres().stream().filter(l -> l.getIsbn().equals(isbn)).findFirst().get();
    }
    private int getNextNumFacture() {
        return listeFactures.size() + 1;
    }
}
