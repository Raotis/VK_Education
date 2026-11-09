package com.example.vkedu1.data

import com.example.vkedu1.data.dto.AppDetailsDto

/** Захардкоженные карточки приложений (в виде DTO). Название, иконка и категория берутся из списка. */
internal val appDetailsDtos: List<AppDetailsDto> = listOf(
    details(
        id = "vk",
        developer = "VK",
        ageRating = 12,
        size = 168.4,
        description = "ВКонтакте — социальная сеть и мессенджер. Общайтесь с друзьями, вступайте " +
            "в сообщества, слушайте музыку, смотрите видео и клипы. Приложение помогает " +
            "быть на связи и узнавать новости из любимых источников.",
    ),
    details(
        id = "telegram",
        developer = "Telegram FZ-LLC",
        ageRating = 16,
        size = 74.2,
        description = "Быстрый и безопасный мессенджер. Создавайте чаты и группы, подписывайтесь " +
            "на каналы, пользуйтесь ботами и отправляйте файлы любого типа. Переписка " +
            "синхронизируется между всеми вашими устройствами.",
    ),
    details(
        id = "maps",
        developer = "Яндекс",
        ageRating = 0,
        size = 118.9,
        description = "Подробная карта города с актуальными организациями. Стройте маршруты " +
            "на машине, общественном транспорте, пешком и на велосипеде, смотрите пробки " +
            "и ориентируйтесь с помощью голосовых подсказок.",
    ),
    details(
        id = "bank",
        developer = "Сбербанк",
        ageRating = 12,
        size = 96.7,
        description = "Управляйте деньгами из одного приложения: переводите средства, оплачивайте " +
            "услуги и штрафы, следите за расходами и накоплениями. Доступен быстрый вход " +
            "по коду или биометрии.",
    ),
    details(
        id = "music",
        developer = "Яндекс",
        ageRating = 6,
        size = 81.3,
        description = "Слушайте музыку, подкасты и аудиокниги. Подборки по настроению и жанрам, " +
            "персональные рекомендации и возможность сохранять треки для прослушивания " +
            "без интернета.",
    ),
    details(
        id = "kinopoisk",
        developer = "Яндекс",
        ageRating = 16,
        size = 102.6,
        description = "Каталог фильмов и сериалов с рейтингами и рецензиями. Узнавайте о новинках " +
            "проката, смотрите трейлеры, составляйте списки к просмотру и находите, " +
            "что посмотреть вечером.",
    ),
    details(
        id = "ozon",
        developer = "Ozon",
        ageRating = 12,
        size = 135.8,
        description = "Покупайте товары на любой вкус с доставкой на дом или в пункт выдачи. " +
            "Сравнивайте цены, читайте отзывы, отслеживайте заказы и получайте " +
            "персональные скидки.",
    ),
    details(
        id = "food",
        developer = "Яндекс",
        ageRating = 12,
        size = 90.1,
        description = "Заказывайте еду из ресторанов и продукты из магазинов рядом с вами. " +
            "Следите за курьером на карте, оплачивайте заказ в приложении и повторяйте " +
            "любимые заказы в один клик.",
    ),
    details(
        id = "gosuslugi",
        developer = "Минцифры России",
        ageRating = 12,
        size = 127.0,
        description = "Государственные услуги онлайн: записывайтесь к врачу, проверяйте штрафы, " +
            "заказывайте справки и храните документы в электронном виде. Уведомления " +
            "о статусе заявлений приходят прямо в приложение.",
    ),
    details(
        id = "duolingo",
        developer = "Duolingo, Inc.",
        ageRating = 4,
        size = 63.5,
        description = "Изучайте языки в формате коротких игровых уроков. Ежедневная практика, " +
            "награды за серии занятий и задания на чтение, письмо, аудирование " +
            "и произношение.",
    ),
    details(
        id = "home",
        developer = "Smart Home Labs",
        ageRating = 0,
        size = 58.2,
        description = "Управляйте светом, розетками и камерами с телефона. Создавайте сценарии " +
            "автоматизации и получайте уведомления о событиях дома.",
    ),
)

private fun details(
    id: String,
    developer: String,
    ageRating: Int,
    size: Double,
    description: String,
): AppDetailsDto {
    val app = appDtos.first { it.id == id }
    return AppDetailsDto(
        id = app.id,
        name = app.name,
        developer = developer,
        category = app.category,
        ageRating = ageRating,
        size = size,
        icon = app.icon,
        iconColor = app.iconColor,
        description = description,
    )
}
