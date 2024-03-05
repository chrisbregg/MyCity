package com.example.mycity.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycity.R
import com.example.mycity.model.Category
import com.example.mycity.ui.theme.MyCityTheme

@Composable
fun CategoryCard(
    @DrawableRes image: Int,
    @StringRes category: Int,
    modifier: Modifier = Modifier
) {
    Card (modifier = modifier){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ){
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                alignment = Alignment.CenterStart,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .weight(1f)
            )
            Text(
                text = stringResource(id = category),
                textAlign = TextAlign.Center,
                style = typography.titleLarge,
                modifier = Modifier
                    .weight(2f)
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun CategoryList(categoryList: List<Category>) {
    LazyColumn {
        itemsIndexed(categoryList) {index, item ->
            CategoryCard(
                item.image,
                item.name,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .height(96.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryCardPreview() {
    val categoryList = listOf(
        Category(
            R.drawable.roasted_coffee_beans,
            R.string.category_coffee
        ),
        Category(
            R.drawable._60_f_324739203_keeq8udvv0p2h1mlyj0glsltbagoxs48,
            R.string.category_restaurant
        )
    )

    MyCityTheme {
        Surface {
            CategoryList(categoryList)
        }
    }
}