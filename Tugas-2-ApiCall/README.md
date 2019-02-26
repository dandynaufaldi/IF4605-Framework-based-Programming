# Tugas 2: Membuat API Call -> Convert JSON Response ke POJO dengan GSON

## API : Oxford Dictionary Thesaurus Antonym Finder

## Sample API Response
### URL Pattern :
`https://od-api.oxforddictionaries.com/api/v1/entries/{language}/{word_id}/antonyms`
### Sample URL: `https://od-api.oxforddictionaries.com/api/v1/entries/en/pretty/antonyms`

### Header : 
```
{
    "app_id" : APP_ID,
    "app_key" : APP_KEY
}
```
### Response: antonym 'pretty'
```json
{
    "metadata": {
        "provider": "Oxford University Press"
    },
    "results": [
        {
            "id": "pretty",
            "language": "en",
            "lexicalEntries": [
                {
                    "entries": [
                        {
                            "homographNumber": "000",
                            "senses": [
                                {
                                    "antonyms": [
                                        {
                                            "id": "plain",
                                            "language": "en",
                                            "text": "plain"
                                        },
                                        {
                                            "id": "ugly",
                                            "language": "en",
                                            "text": "ugly"
                                        }
                                    ],
                                    "examples": [
                                        {
                                            "text": "a pretty child"
                                        }
                                    ],
                                    "id": "t_en_gb0011544.001",
                                    "subsenses": [
                                        {
                                            "id": "id2d290668-1527-4002-a5dd-5759268d8909"
                                        },
                                        {
                                            "id": "idfc3cface-2dc4-4a05-8f8c-663a718a4e92"
                                        },
                                        {
                                            "id": "id79d26f80-adec-4e12-9c33-38bfefb596c2"
                                        },
                                        {
                                            "id": "idf22e2a18-1ed2-4a91-883a-d2e73e0656af"
                                        },
                                        {
                                            "id": "idadc395a9-c4d0-42aa-ace8-fd4d89bf96f6",
                                            "regions": [
                                                "Scottish",
                                                "Northern English"
                                            ]
                                        },
                                        {
                                            "id": "idc4e41e3e-887c-473e-8330-e6db6cbf79ef",
                                            "registers": [
                                                "informal"
                                            ]
                                        },
                                        {
                                            "id": "idef35adaf-468c-4042-a6ea-3380a46b2a18",
                                            "registers": [
                                                "literary"
                                            ]
                                        },
                                        {
                                            "id": "id5b48fc36-0490-4539-8e70-c107f6165e1a",
                                            "registers": [
                                                "archaic"
                                            ]
                                        }
                                    ]
                                }
                            ]
                        }
                    ],
                    "language": "en",
                    "lexicalCategory": "Adjective",
                    "text": "pretty"
                }
            ],
            "type": "headword",
            "word": "pretty"
        }
    ]
}
```
### POJO String Representation
```
Antonyms for pretty in language EN
Category: Adjective
[ANTONYMS]
- plain
- ugly
[EXAMPLE]
- a pretty child
```