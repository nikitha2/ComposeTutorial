package com.example.composetutorial

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable

object SampleData {
    val conversationSample = listOf(
        Message(
            "Colleague",
            "Test...Test...Test..."
        ),
        Message(
            "Colleague",
            "List of Android versions:\n" +
                    "Android KitKat (API 19)\n" +
                    "Android Lollipop (API 21)\n" +
                    "Android Marshmallow (API 23)\n" +
                    "Android Nougat (API 24)\n" +
                    "Android Oreo (API 26)\n" +
                    "Android Pie (API 28)\n" +
                    "Android 10 (API 29)\n" +
                    "Android 11 (API 30)\n" +
                    "Android 12 (API 31)\n"
        ),
        Message(
            "Colleague",
            "I think Kotlin is my favorite programming language.\n" +
                    "It's so much fun!"
        ),
        Message(
            "Colleague",
            "Searching for alternatives to XML layouts..."
        ),
        Message(
            "Colleague",
            "Hey, take a look at Jetpack Compose, it's great!\n" +
                    "It's the Android's modern toolkit for building native UI." +
                    "It simplifies and accelerates UI development on Android." +
                    "Less code, powerful tools, and intuitive Kotlin APIs :)"
        ),
        Message(
            "Colleague",
            "It's available from API 21+ :)"
        ),
        Message(
            "Colleague",
            "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
        ),
        Message(
            "Colleague",
            "Android Studio next version's name is Arctic Fox"
        ),
        Message(
            "Colleague",
            "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
        ),
        Message(
            "Colleague",
            "I didn't know you can now run the emulator directly from Android Studio"
        ),
        Message(
            "Colleague",
            "Compose Previews are great to check quickly how a composable layout looks like"
        ),
        Message(
            "Colleague",
            "Previews are also interactive after enabling the experimental setting"
        ),
        Message(
            "Colleague",
            "Have you tried writing build.gradle with KTS?"
        ),
    )

    val conversationSample1 = listOf(
        Message(
            "Colleague",
            "Test...Test...Test..."
        ),
        Message(
            "Colleague",
            "Can you hear me?"
        ),
        Message(
            "Colleague",
            "Hey, take a look at Jetpack Compose, it's great!\n" +
                    "It's the Android's modern toolkit for building native UI." +
                    "It simplifies and accelerates UI development on Android." +
                    "Less code, powerful tools, and intuitive Kotlin APIs :)"
        ))

    val buttons = listOf(
        MainActivity.Button("Compose overview CodeLab","ComposeOverviewTutorialActivity"),
        MainActivity.Button("Compose basics CodeLab","ComposeBasicsActivity"),
        MainActivity.Button("Compose Migration CodeLab","ComposeMigrateActivity"),
        MainActivity.Button("Compose Basic layouts CodeLab","ComposeBasicLayoutsActivity"),
        MainActivity.Button("Compose Theme layouts CodeLab","ComposeThemeLayoutsActivity"),
        MainActivity.Button("State in Compose CodeLab","ComposeStateActivity"))

    val cards = listOf(
        ComposeBasicsActivity.Greeting("Hello, 1","This is the content for 1!"),
        ComposeBasicsActivity.Greeting("Hello, 2","This is the content for 2!"),
        ComposeBasicsActivity.Greeting("Hello, 3","This is the content for 3!"),
        ComposeBasicsActivity.Greeting("Hello, 4","This is the content for 4!"),
        ComposeBasicsActivity.Greeting("Hello, 5","This is the content for 5!"),
        ComposeBasicsActivity.Greeting("Hello, 6","This is the content for 6!"),
        ComposeBasicsActivity.Greeting("Hello, 7","This is the content for 7!"),
        ComposeBasicsActivity.Greeting("Hello, 8","This is the content for 8!"),
        ComposeBasicsActivity.Greeting("Hello, 9","This is the content for 9!"),
        ComposeBasicsActivity.Greeting("Hello, 10","This is the content for 10!"),
        ComposeBasicsActivity.Greeting("Hello, 11","This is the content for 11!"),
        ComposeBasicsActivity.Greeting("Hello, 12","This is the content for 12!"),
        ComposeBasicsActivity.Greeting("Hello, 13","This is the content for 13!"),
        ComposeBasicsActivity.Greeting("Hello, 14","This is the content for 14!"),
        ComposeBasicsActivity.Greeting("Hello, 15","This is the content for 15!"),
        ComposeBasicsActivity.Greeting("Hello, 16","This is the content for 16!"),
        ComposeBasicsActivity.Greeting("Hello, 17","This is the content for 17!"),
        ComposeBasicsActivity.Greeting("Hello, 18","This is the content for 18!"),
        ComposeBasicsActivity.Greeting("Hello, 19","This is the content for 19!"),
        ComposeBasicsActivity.Greeting("Hello, 20","This is the content for 20!"))

    val workouts=listOf(
        ComposeBasicLayoutsActivity.Workout("Inversions",R.drawable.image5),
        ComposeBasicLayoutsActivity.Workout("Natural meditation",R.drawable.images),
        ComposeBasicLayoutsActivity.Workout("Self massage", R.drawable.images3),
        ComposeBasicLayoutsActivity.Workout("Stress and anxiety",R.drawable.images4),
        ComposeBasicLayoutsActivity.Workout("Inversions",R.drawable.img1)
    )


    //Theme code lab

    @Immutable
    data class Post(
        val id: Long,
        val title: String,
        val subtitle: String? = null,
        val url: String,
        val metadata: Metadata,
        @DrawableRes val imageId: Int,
        @DrawableRes val imageThumbId: Int,
        val tags: Set<String>
    )

    @Immutable
    data class Metadata(
        val author: PostAuthor,
        val date: String,
        val readTimeMinutes: Int
    )

    @Immutable
    data class PostAuthor(
        val name: String,
        val url: String? = null
    )


    /**
     * A fake repo returning sample data
     */
    object PostRepo {
        fun getPosts(): List<Post> = posts
        fun getFeaturedPost(): Post = posts.random()
    }

    /**
     * Sample Data
     */

    private val pietro = PostAuthor("Pietro Maggi", "https://medium.com/@pmaggi")
    private val manuel = PostAuthor("Manuel Vivo", "https://medium.com/@manuelvicnt")
    private val florina = PostAuthor("Florina Muntenescu", "https://medium.com/@florina.muntenescu")
    private val jose = PostAuthor("Jose Alcérreca", "https://medium.com/@JoseAlcerreca")

    private val post1 = Post(
        id = 1L,
        title = "A Little Thing about Android Module Paths",
        subtitle = "How to configure your module paths, instead of using Gradle’s default.",
        url = "https://medium.com/androiddevelopers/gradle-path-configuration-dc523f0ed25c",
        metadata = Metadata(
            author = pietro,
            date = "August 02",
            readTimeMinutes = 1
        ),
        imageId = R.drawable.post_1,
        imageThumbId = R.drawable.post_1_thumb,
        tags = setOf("Modularization", "Gradle")
    )

    private val post2 = Post(
        id = 2L,
        title = "Dagger in Kotlin: Gotchas and Optimizations",
        subtitle = "Use Dagger in Kotlin! This article includes best practices to optimize your build time and gotchas you might encounter.",
        url = "https://medium.com/androiddevelopers/dagger-in-kotlin-gotchas-and-optimizations-7446d8dfd7dc",
        metadata = Metadata(
            author = manuel,
            date = "July 30",
            readTimeMinutes = 3
        ),
        imageId = R.drawable.post_2,
        imageThumbId = R.drawable.post_2_thumb,
        tags = setOf("Dagger", "Kotlin")
    )

    private val post3 = Post(
        id = 3L,
        title = "From Java Programming Language to Kotlin — the idiomatic way",
        subtitle = "Learn how to get started converting Java Programming Language code to Kotlin, making it more idiomatic and avoid common pitfalls, by…",
        url = "https://medium.com/androiddevelopers/from-java-programming-language-to-kotlin-the-idiomatic-way-ac552dcc1741",
        metadata = Metadata(
            author = florina,
            date = "July 09",
            readTimeMinutes = 1
        ),
        imageId = R.drawable.post_3,
        imageThumbId = R.drawable.post_3_thumb,
        tags = setOf("Kotlin")
    )

    private val post4 = Post(
        id = 4L,
        title = "Locale changes and the AndroidViewModel antipattern",
        subtitle = "TL;DR: Expose resource IDs from ViewModels to avoid showing obsolete data.",
        url = "https://medium.com/androiddevelopers/locale-changes-and-the-androidviewmodel-antipattern-84eb677660d9",
        metadata = Metadata(
            author = jose,
            date = "April 02",
            readTimeMinutes = 1
        ),
        imageId = R.drawable.post_4,
        imageThumbId = R.drawable.post_4_thumb,
        tags = setOf("ViewModel", "Locale")
    )

    private val post5 = Post(
        id = 5L,
        title = "Collections and sequences in Kotlin",
        subtitle = "Working with collections is a common task and the Kotlin Standard Library offers many great utility functions. It also offers two ways of…",
        url = "https://medium.com/androiddevelopers/collections-and-sequences-in-kotlin-55db18283aca",
        metadata = Metadata(
            author = florina,
            date = "July 24",
            readTimeMinutes = 4
        ),
        imageId = R.drawable.post_5,
        imageThumbId = R.drawable.post_5_thumb,
        tags = setOf("Kotlin", "Collections", "Sequences")
    )

    private val posts = listOf(
        post1,
        post2,
        post3,
        post4,
        post5,
        post1.copy(id = 6L),
        post2.copy(id = 7L),
        post3.copy(id = 8L),
        post4.copy(id = 9L),
        post5.copy(id = 10L)
    )

    val noteItems = listOf(
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10",
        "11",
        "12",
        "13",
        "14",
        "15",
        "16",
        "17",
        "18",
        "19",
        "20",
        "21",
        "22",
        "23",
        "24",
        "25"
    )
}
