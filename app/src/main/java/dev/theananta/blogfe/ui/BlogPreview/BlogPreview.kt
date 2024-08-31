package dev.theananta.blogfe.ui.BlogPreview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.theananta.blogfe.R
import dev.theananta.blogfe.SearchComp
import dev.theananta.blogfe.data.BlogData
import dev.theananta.blogfe.ui.theme.BlogFETheme

@Composable
fun BlogPreview(blogData: BlogData, modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(10.dp),
        color = MaterialTheme.colorScheme.surfaceVariant,
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            contentAlignment = Alignment.TopStart
        ) {
            Column {
                TopComp(
                    title = blogData.title,
                    timeAgo = blogData.timeAgo,
                    blogTitle = blogData.blogTitle,
                    desc = blogData.desc,
                    modifier = Modifier
                )
            }
        }
    }
}


@Composable
fun TopComp(title: String, timeAgo: String, blogTitle: String, desc: String, modifier: Modifier = Modifier) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Image(
                    painter = painterResource(R.drawable.umbrella),
                    contentDescription = "The colour full umbrella icon",
                    modifier = Modifier.size(20.dp),
                    contentScale = ContentScale.FillWidth
                )

                Column {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text = timeAgo,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }

            Surface(
                modifier = modifier
                    .size(40.dp),
                shape = CircleShape
            ) {
                Icon(
                    imageVector = Icons.Outlined.Star,
                    contentDescription = "Outline start",
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(10.dp),
                )
            }
        }

        Text(
            text = blogTitle,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 18.dp, start = 12.dp)
        )
        Text(
            text = desc,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(top = 4.dp, start = 12.dp)
        )
    }
}

