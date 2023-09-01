using System.Net.Http;
using System.Text;
using Newtonsoft.Json;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;
using System.Collections;

public class BtnLogin : MonoBehaviour
{
    [SerializeField] private InputField inputEmail;
    [SerializeField] private InputField inputPassword;
    [SerializeField] private GameObject dialogNotification;
    [SerializeField] private Text txtLoading;
    [SerializeField] private Text txtShowNotification;
    // Start is called before the first frame update
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {

    }

    public void login()
    {
        string email = inputEmail.text;
        string password = inputPassword.text;

        User user = new User(email, password);
        sendUserAsync(user);
    }

    async private void sendUserAsync(User user)
    {
        txtLoading.text = null;
        txtShowNotification.text = null;
        dialogNotification.SetActive(true);

        StartCoroutine(runLoading());

        var content = new StringContent(JsonConvert.SerializeObject(user), Encoding.UTF8, "application/json");
        using (var httpClient = new HttpClient())
        {
            using (var response = await httpClient.PostAsync("https://rich-plum-pocket.cyclic.app/api/mob104/user/login", content))
            {
                string responseData = await response.Content.ReadAsStringAsync();
                try
                {
                    UserResponse userResponse = JsonConvert.DeserializeObject<UserResponse>(responseData);
                    if (userResponse.status == 200)
                    {
                        UserResponse.setInstance(userResponse);
                        StartCoroutine(runShowNotification("Login successfully wait for minutes...", userResponse));

                    }
                    else
                    {
                        StartCoroutine(runShowNotification("Login failed", null));
                    }
                }
                catch (System.Exception)
                {
                    StartCoroutine(runShowNotification("Login failed", null));
                }
            }
        }
    }

    private void loadScene(UserResponse userResponse)
    {
        SceneManager.LoadScene(userResponse.scene);
    }
    IEnumerator runLoading()
    {
        yield return StartCoroutine(Loading());
    }
    IEnumerator runShowNotification(string s, UserResponse userResponse)
    {
        yield return StartCoroutine(ShowNotification(s));
        if (userResponse != null)
        {
            loadScene(userResponse);
        }
    }
    IEnumerator Loading()
    {
        string loading = "Loading...";
        for (int i = 0; i < loading.Length; i++)
        {
            txtLoading.text += loading[i];
            yield return new WaitForSeconds(0.2f);
        }
    }

    IEnumerator ShowNotification(string s)
    {
        for (int i = 0; i < s.Length; i++)
        {
            txtShowNotification.text += s[i];
            yield return new WaitForSeconds(0.02f);
        }

        yield return new WaitForSeconds(2f);
        dialogNotification.SetActive(false);
    }
}
