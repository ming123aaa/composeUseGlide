
让glide支持compose的代码:
[GlideImage.kt](composeForGlide/src/main/java/com/ohuang/composeforglide/GlideImage.kt)


使用:
```kotlin

    ImageGlide(id = R.mipmap.ic_launcher)

    ImageGlide(url = "xxx")

    ImageGlide() {
        load("xxx")
            .error(R.mipmap.ic_launcher)
            .placeholder(R.drawable.ic_launcher_background)

    }
```
