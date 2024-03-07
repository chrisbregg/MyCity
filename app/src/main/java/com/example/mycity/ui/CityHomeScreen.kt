package com.example.mycity.ui

import android.location.Address
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
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
import com.example.mycity.model.Location
import com.example.mycity.ui.theme.MyCityTheme
import java.util.Locale

enum class CityHomeScreen() {
    Start,
    Category,
    Detail
}

@Composable
fun ItemCard(
    @DrawableRes image: Int,
    text: String,
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
                text = text,
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
            ItemCard(
                item.image,
                stringResource(id = item.name),
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .height(96.dp)
            )
        }
    }
}

@Composable
fun RecommendationList(recommendationList: List<Location>) {
    LazyColumn {
        itemsIndexed(recommendationList) {index, item ->
            ItemCard(
                item.image,
                stringResource(id = item.name),
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .height(96.dp)
            )
        }
    }
}

@Composable
fun DetailView(
    location: Location,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
    ) {
        Column(
        ) {
            Text(
                text = stringResource(location.name),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Image(
                painter = painterResource(id = location.image),
                contentDescription = null,
                alignment = Alignment.CenterStart,
                contentScale = ContentScale.Fit
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "Category:"
                )
                Text(
                    text = stringResource(id = location.category.name)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "Description:"
                )
                Text(
                    text = stringResource(id = location.description)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "Category:"
                )
                Text(
                    text = stringResource(id = location.category.name)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "Location:"
                )
                Text(
                    text = "Filler Text"
                )
            }
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

@Preview(showBackground = true)
@Composable
fun RecommendationPreview() {
    val recommendationList = listOf(
        Location(
            name = R.string.location_coffee_cravings,
            category = Category(
                R.drawable.roasted_coffee_beans,
                R.string.category_coffee
            ),
            description = R.string.location_coffee_cravings_description,
            address = Address(Locale("CA")),
            R.drawable.pxl_20230526_172717068
        )
    )

    MyCityTheme {
        Surface {
            RecommendationList(recommendationList)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailPreview() {
    val recommendationList = listOf(
        Location(
            name = R.string.location_coffee_cravings,
            category = Category(
                R.drawable.roasted_coffee_beans,
                R.string.category_coffee
            ),
            description = R.string.location_coffee_cravings_description,
            address = Address(Locale("CA")),
            R.drawable.pxl_20230526_172717068
        )
    )

    MyCityTheme {
        Surface {
            DetailView(recommendationList[0],
                Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                )
        }
    }
}