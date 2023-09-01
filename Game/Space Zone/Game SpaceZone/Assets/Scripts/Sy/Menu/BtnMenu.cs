using System;
using System.Collections;
using System.Collections.Generic;
using System.Net.Http;
using System.Text;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class BtnMenu : MonoBehaviour
{
    [SerializeField] private Transform player;
    [SerializeField] private InputField inputName;
    [SerializeField] private InputField inputAge;
    // Start is called before the first frame update
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {

    }

    public void openMenu()
    {
        Time.timeScale = 0;
    }

    public void exitMenu()
    {
        Time.timeScale = 1;
    }

    public void exitGame()
    {
        Application.Quit();
    }
    public async void saveGame()
    {
        UserResponse userResponse = UserResponse.getInstance();
        JObject jObject = new JObject();
        jObject.Add("id", userResponse.id);
        jObject.Add("score", ScoreManger.getScoreTotal());
        jObject.Add("scene", SceneManager.GetActiveScene().name);
        jObject.Add("positionx", player.position.x);
        jObject.Add("positiony", player.position.y);
        jObject.Add("positionz", player.position.z);

        using (var client = new HttpClient())
        {
            var content = new StringContent(JsonConvert.SerializeObject(jObject), Encoding.UTF8, "application/json");
            Debug.Log(JsonConvert.SerializeObject(jObject));
            var response = await client.PutAsync("https://rich-plum-pocket.cyclic.app/api/mob104/user/save-data", content);
            var responseString = await response.Content.ReadAsStringAsync();
            Debug.Log(responseString);
        }
    }

    public async void editUser()
    {
        UserResponse userResponse = UserResponse.getInstance();
        JObject jObject = new JObject();
        jObject.Add("id", userResponse.id);
        jObject.Add("name", inputName.text);
        jObject.Add("age", Int32.Parse(inputAge.text));

        using (var client = new HttpClient())
        {
            var content = new StringContent(JsonConvert.SerializeObject(jObject), Encoding.UTF8, "application/json");
            Debug.Log(JsonConvert.SerializeObject(jObject));
            var response = await client.PutAsync("https://rich-plum-pocket.cyclic.app/api/mob104/user/save-data", content);
            var responseString = await response.Content.ReadAsStringAsync();
            Debug.Log(responseString);
        }
    }
}
